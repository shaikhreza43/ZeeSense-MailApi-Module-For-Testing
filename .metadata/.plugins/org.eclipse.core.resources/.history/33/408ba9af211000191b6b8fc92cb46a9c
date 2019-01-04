    var emailApp = angular.module('app');
    emailApp.controller('mailApp', ["$scope", "$log", function ($scope, $log) {
        $scope.composemail = {};
        $scope.sendEmail = function () {
            $scope.isComposePopupVisible = false;
            // alert($scope.composemail.to 
            //     + " "+" "+$scope.composemail.cc+" "+$scope.composemail.bcc+" " + $scope.composemail.subject
            //     + " " + $scope.composemail.body);

            if(($scope.composemail.to & $scope.composemail.subject)==undefined){
                alert('Please Mention Receipent\'s mail, a subject and Body');
                $log.log('Please Mention Receipent\'s mail, a subject and Body');
            }
            if($scope.composemail.subject==undefined){
                confirm('Do you want to Send mail without any subject???');
            }

            else if((($scope.composemail.body & $scope.composemail.to) & $scope.composemail.subject)!=undefined){
            alert("Email Sent Successfully");
            $log.log('Email Sent Successfully');
            }
            else{
            alert('Can\'t send without Receipent\'s mail');
            $log.log('Can\'t send without Receipent\'s mail');
        }
            };

        $scope.savedraft = function () {
            //alert($scope.composemail.body);
            if($scope.composemail.to==undefined){
               $log.log('Can\'t save empty email,Please Fill all the Required fields');
                alert('Can\'t save empty email,Please Fill all the Required fields');
               }
             else if($scope.composemail.subject==undefined){
               $log.log('Can\'t save empty email,Please Fill all the Required fields');
                        alert('Can\'t save empty email,Please Fill all the Required fields');
               }

             else if($scope.composemail.body==undefined){
               $log.log('Can\'t save empty email,Please Fill all the Required fields');
                        alert('Can\'t save empty email,Please Fill all the Required fields');
               }
            else{
                alert("Message saved as draft");
                $log.error("Message saved as Draft");
            }
        };

        $scope.showComposePopup = function () {
            $scope.composeEmail = {};
            $scope.isComposePopupVisible = true;
        };

    }]);