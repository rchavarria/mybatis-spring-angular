(function () {
    "use strict";

    var librarian = angular.module("librarian", [
        "ngRoute",
        "ngResource",
        "ngTable"
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

    librarian.controller("CoursesCatalogCtrl", ["$scope", "$filter", "ngTableParams", "CourseServiceResource", 
        function ($scope, $filter, ngTableParams, CourseServiceResource) {
        
        $scope.coursesTable = new ngTableParams({
            page: 1,            // show first page
            count: 10,          // count per page
            sorting: {
                name: 'asc'     // initial sorting
            }
        }, {
            total: 0, // length of data
            getData: function($defer, params) {
                CourseServiceResource.query(function (data) {
                    console.log("querying course service resource, total = " + data.length);
                    
                    params.total(data.length);
                    var orderedData = params.sorting() ?
                            $filter('orderBy')(data, params.orderBy()) :
                            $scope.courses;
                  
                  $defer.resolve(orderedData.slice((params.page() - 1) * params.count(), params.page() * params.count()));
                });
                // use build-in angular filter
            }
        });
    }]);

    librarian.controller("CreateCourseCtrl", ["$scope", function ($scope) {
        $scope.idCourse = 123454321;
    }]);
}());
