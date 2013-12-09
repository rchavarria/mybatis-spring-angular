/*global describe, beforeEach, it, expect */
describe("Courses catalog controller", function () {
    "use strict";
    
    beforeEach(module("librarian"));
    
    it("stores something in model 'name'", inject(function ($controller) {
        var scope = {},
            ctrl = $controller("CoursesCatalogCtrl", { $scope: scope });
        
        expect(scope.name).toEqual("world");
    }));
});