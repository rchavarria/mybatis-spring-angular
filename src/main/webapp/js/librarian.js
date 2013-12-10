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

        var tableParams = {
                page: 1,
                count: 5,
                sorting: { title: 'asc' }
            },
            tableSettings = {
                total: 0,
                counts: [5, 10, 25, 50],
                getData: function($defer, params) {
                    console.log("getting data");
                    CourseServiceResource.query(function (data) {
                        console.log("querying data");
                        // update length of data
                        params.total(data.length);

                        console.log("some calculations");
                        var currentPage = params.page(),
                            count = params.count(),
                            orderedData = params.sorting() ?
                                $filter('orderBy')(data, params.orderBy()) :
                                data,
                            paginatedData = orderedData.slice((currentPage - 1) * count, currentPage * count);

                        console.log("current page: " + currentPage);
                        console.log("count: " + count);
                        console.log("ordered data: " + orderedData);
                        console.log("paginated data: " + paginatedData);

                        $defer.resolve(paginatedData);
                    });
                }
            };

        $scope.coursesTable = new ngTableParams(tableParams, tableSettings);
    }]);

    librarian.controller("CreateCourseCtrl", ["$scope", "TeacherServiceResource", "LevelServiceResource", 
        function ($scope, TeacherServiceResource, LevelServiceResource) {

        $scope.teachers = [
           { idTeacher: 0, name: "TeAcHeR 1" },
           { idTeacher: 1, name: "TeAcHeR 2" },
           { idTeacher: 2, name: "TeAcHeR 3" },
           ];
        $scope.levels = ["bAsIc", "InTeRmeDiAtE", "AdVaNcEd"];
//        $scope.teachers = TeacherServiceResource.query();
//        $scope.levels = LevelServiceResource.query();
    }]);
}());
