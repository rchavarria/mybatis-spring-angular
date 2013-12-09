
describe("Courses catalog controller", function () {
    
    beforeEach(module("librarian"));
    
    it("stores something in model 'name'", inject(function ($controller) {
        var scope = {},
            ctrl = $controller("CoursesCatalogCtrl", { $scope: scope });
        
        expect(scope.name).toEqual("world");
    }));
});