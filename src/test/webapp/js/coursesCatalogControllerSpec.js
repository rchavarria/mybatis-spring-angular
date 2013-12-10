/*global angular, describe, beforeEach, it, expect */
describe("Courses catalog controller", function () {
    "use strict";
    
    var scope, ctrl, $httpBackend, returnedCourses;
    
    // adds a new Jasmine matcher, toEqualData, to check only data in 
    //object and ignore functions
    beforeEach(function () {
        this.addMatchers({
            toEqualData: function(expected) {
                return angular.equals(this.actual, expected);
            }
        });
    });
    
    // data fixture
    returnedCourses = function () {
        return [
            { title: "Title 1" },
            { title: "Title 2" },
            { title: "Title 3" },
            { title: "Title 4" },
            { title: "Title 5" },
            { title: "Title 6" }
        ];
    };

    // load the application module and its dependencies
    beforeEach(module("librarian"));
    beforeEach(module("ngTable"));

    // mock $http and $resource backend
    beforeEach(inject(function(_$httpBackend_, $rootScope, $controller) {
        $httpBackend = _$httpBackend_;
        $httpBackend.expectGET('courses').respond(returnedCourses());
   
        scope = $rootScope.$new();
        ctrl = $controller("CoursesCatalogCtrl", { $scope: scope });
    }));

    describe("initial configuration", function () {

        it("starts at page 1", function () {
            expect(scope.coursesTable.page()).toBe(1);
        });

        it("counts 5 by 5", function () {
            expect(scope.coursesTable.count()).toBe(5);
        });

        it("orders data by the 'title' column, ascending", function () {
            expect(scope.coursesTable.sorting()).toEqual({ title: 'asc' });
        });

        it("has a initial total of 0", function () {
            expect(scope.coursesTable.total()).toBe(0);
        });

        it("will paginate with page sizes of [5, 10, 25, 50]", function () {
            expect(scope.coursesTable.settings().counts).toEqual([5, 10, 25, 50]);
        });
    });

    describe("pagination", function () {

        it("retrieves the first page by default", inject(function ($q) {
            var tableParams = scope.coursesTable,
                $defer = $q.defer();

            $defer.promise.then(function (data) {
                $httpBackend.flush();

                expect(data.length).toBe(tableParams.count());
                expect(data).toEqualData(returnedCourses().slice(0, tableParams.count()));
            });

            tableParams.getData($defer, tableParams);
        }));

        it("gets a second page with the rest of the data", inject(function ($q) {
            var tableParams = scope.coursesTable,
                $defer = $q.defer();

            $defer.promise.then(function (data) {
                $httpBackend.flush();

                var count = tableParams.count(),
                    completeDataLength = returnedCourses().length;

                expect(data.length).toBe(completeDataLength - count);
                expect(data).toEqualData(returnedCourses().slice(count, completeDataLength));
            });

            tableParams.page(2); // second page
            tableParams.getData($defer, tableParams);
        }));
    });
});