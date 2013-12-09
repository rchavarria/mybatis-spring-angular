/**
 * it contains a services to help controllers to do their job
 */
(function () {
    "use strict";

    // get the main module
    var librarian = angular.module("librarian");

    librarian.factory("CourseServiceResource", ["$resource", function ($resource) {
        return $resource('courses');
    }]);
}());
