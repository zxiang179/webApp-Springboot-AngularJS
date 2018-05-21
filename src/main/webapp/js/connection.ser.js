(function () {
    'use strict';
    var utils = angular.module('Utils', []);
    utils.service('Connection', ['$http', Connection]);

    function Connection($http) {
        var conn = {};

        conn.post = post;
        conn.get = get;

        return conn;

        function post(url, params, callback) {
            $http({
                      method: 'POST',
                      url: url,
                      params: params
                  }).then(function successCallback(response) {
                callback(response)
            }, function errorCallback(response) {
                alert(response);
            });
        }

        function get(url, params, callback) {
            $http({
                      method: 'GET',
                      url: url,
                      params: params
                  }).then(function successCallback(response) {
                callback(response)
            }, function errorCallback(response) {
                alert(response);
            });
        }
    }

})();