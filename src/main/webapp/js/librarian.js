(function () {
    "use strict";

    var librarian = angular.module("librarian", [
        "ngRoute"
    ]);

    // config routes and different views for each route
    librarian.config(["$routeProvider", function ($rootProvider) {
        $rootProvider
            .when("/coursesCatalog", {
                templateUrl: "partials/coursesCatalog.html",
                controller: "CoursesCatalogCtrl"
            })
            .when("/creatingCourse", {
                templateUrl: "partials/creatingCourse.html",
                controller: "CreateCourseCtrl"
            })
            .otherwise({
                redirectTo: "/coursesCatalog"
            });
    }]);

    librarian.controller("CoursesCatalogCtrl", ["$scope", function ($scope) {
        $scope.name = "world";
    }]);

    librarian.controller("CreateCourseCtrl", ["$scope", function ($scope) {
        $scope.idCourse = 123454321;
    }]);
}());
