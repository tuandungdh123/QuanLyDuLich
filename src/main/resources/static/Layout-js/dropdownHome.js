angular
    .controller('allproductCtrl', function ($scope, $interval,$rootScope, $http) {
        $scope.infor = 'Hello everybody!';
        $interval(function () {
            $scope.now = new Date();
        }, 1000);
        $scope.page = 1;
        $scope.limit = 12;
        $scope.start = $scope.limit * ($scope.page - 1);
        $scope.totalPage = Math.ceil($scope.dssp.length / $scope.limit);
        $scope.chuyenTrang = function (trang) {
            $scope.page = trang;
            $scope.start = $scope.limit * ($scope.page - 1);
        }
        $scope.dsTrang = [];
        for (var i = 1; i <= $scope.totalPage; i++) {
            $scope.dsTrang.push(i);
        }
        $scope.dsTinh = [];
        $http.get('https://raw.githubusercontent.com/kenzouno1/DiaGioiHanhChinhVN/master/data.json?fbclid=IwAR3FNwt9nAXMC05oMchFEEs-5B-b6zS2t4r6aMhECz2aTS1naxo9i261UQw')
            .then(
                function (res) {
                    // thành công
                    $scope.dsTinh = res.data;
                },
                function (res) {
                    //thất bại
                    alert('Lỗi lấy dữ liệu!');
                }
            )
    })