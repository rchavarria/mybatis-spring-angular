/*global angular, describe, beforeEach, it, expect */
describe("Services to get resources", function () {
    "use strict";
    
    var $httpBackend, 
        returnedData = function () {
            return ["returned", "data"];
        };
    
    // load the application module and its dependencies
    beforeEach(module("librarian"));

    // mock $http and $resource backend
    beforeEach(inject(function(_$httpBackend_) {
        $httpBackend = _$httpBackend_;
    }));

    describe("Course service resource", function () {
        
        it("invokes /courses url", inject(function (CourseServiceResource) {
            $httpBackend.expectGET('courses').respond(returnedData());

            var result = CourseServiceResource.query();
            $httpBackend.flush();
            
            expect(result).not.toEqual(returnedData());
        }));
    });

    describe("Teacher service resource", function () {
        
        it("invokes /courses url", inject(function (TeacherServiceResource) {
            $httpBackend.expectGET('teachers').respond(returnedData());

            var result = TeacherServiceResource.query();
            $httpBackend.flush();
            
            expect(result).not.toEqual(returnedData());
        }));
    });

    describe("Level service resource", function () {
        
        it("invokes /courses url", inject(function (LevelServiceResource) {
            $httpBackend.expectGET('levels').respond(returnedData());

            var result = LevelServiceResource.query();
            $httpBackend.flush();
            
            expect(result).not.toEqual(returnedData());
        }));
    });

});