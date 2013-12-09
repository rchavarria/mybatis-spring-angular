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
            { name: "Title 1" },
            { name: "Title 2" } 
        ];
    };
    
    // load module
    beforeEach(module("librarian"));
    
    // mock $http and $resource backend
    beforeEach(inject(function(_$httpBackend_, $rootScope, $controller) {
        $httpBackend = _$httpBackend_;
        $httpBackend.expectGET('courses').respond(returnedCourses());
   
        scope = $rootScope.$new();
        ctrl = $controller("CoursesCatalogCtrl", { $scope: scope });
      }));
    
    it("retrieves data from a $resource", inject(function ($controller) {
        expect(scope.courses).toEqualData([]); // not invoked yet
        $httpBackend.flush();
        
        expect(scope.courses).toEqualData(returnedCourses());
    }));
});