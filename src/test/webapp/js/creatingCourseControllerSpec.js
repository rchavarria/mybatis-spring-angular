/*global angular, describe, beforeEach, it, expect */
describe("Creating course controller", function () {
    "use strict";
    
    var scope, ctrl, $httpBackend, returnedTeachers, returnedLevels;
    
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
    returnedTeachers = function () {
        return [
            { idTeacher: 0, name: "Teacher 1" },
            { idTeacher: 1, name: "Teacher 2" },
            { idTeacher: 2, name: "Teacher 3" }
        ];
    };
    
    returnedLevels = function () {
        return [
            { level: "BASIC" },
            { level: "INTERMEDIATE" },
            { level: "ADVANCED" }
        ];
    };
    
    // load the application module and its dependencies
    beforeEach(module("librarian"));

    beforeEach(inject(function(_$httpBackend_, $rootScope, $controller) {
        $httpBackend = _$httpBackend_;
        $httpBackend.expectGET("teachers").respond(returnedTeachers());
        $httpBackend.expectGET("levels").respond(returnedLevels());
        
        scope = $rootScope.$new();
        ctrl = $controller("CreateCourseCtrl", { $scope: scope });
    }));
    
    it("invokes 'teachers' to get all of them from the server", function () {
        $httpBackend.flush();
        expect(scope.teachers.length).toBe(3);
        expect(scope.teachers).toEqualData(returnedTeachers());
    });
    
    it("invokes 'levels' to get all of them from the server", function () {
        $httpBackend.flush();
        expect(scope.levels.length).toBe(3);
        expect(scope.levels).toEqualData(returnedLevels());
    });
    
    it("sends data using POST to 'courses' via save() method", function () {
        var expectedCourseToBeSent = {title: "dummy", teacher: 1234, level: "foo"};
        $httpBackend.expectPOST("courses", expectedCourseToBeSent, undefined).respond(201, "");

        scope.course = expectedCourseToBeSent;
        scope.save();
    })

});