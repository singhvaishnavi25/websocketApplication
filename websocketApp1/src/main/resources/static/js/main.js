'use strict';

$(function () {
    var stompClient = null;
    var suggestions = [];

    function connect() {
        var socket = new SockJS('/websocket');
        stompClient = Stomp.over(socket);
        stompClient.connect({}, function (frame) {
            console.log('Connected: ' + frame);
            stompClient.subscribe('/topic/suggestions', function (message) {
                suggestions = JSON.parse(message.body);
            });
        });
    }

    function disconnect() {
        if (stompClient !== null) {
            stompClient.disconnect();
        }
        console.log("Disconnected");
    }

    function search(keyword) {
        stompClient.send("/app/auto-suggest", {}, keyword);
    }

    $("#search-box").autocomplete({
        source: function (request, response) {
            var keyword = request.term;
            if (keyword.length >= 3) {
                search(keyword);
                setTimeout(function () {
                    response(suggestions);
                }, 500);
            }
        }
    });

    connect();
});
