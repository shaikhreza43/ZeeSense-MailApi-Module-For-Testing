'use strict';

// function checkAll(ele) {
//     var checkboxes = document.getElementsByTagName('input');
//     if (ele.checked) {
//         for (var i = 0; i < checkboxes.length; i++) {
//             if (checkboxes[i].type == 'checkbox') {
//                 checkboxes[i].checked = true;
//             }
//         }
//     } else {
//         for (var i = 0; i < checkboxes.length; i++) {
//             console.log(i)
//             if (checkboxes[i].type == 'checkbox') {
//                 checkboxes[i].checked = false;
//             }
//         }
//     }
// }

angular.module('app').factory('sendmail',function($rootScope,$scope,$http,$location,composemail){
    return {
       composemail: function (parm, callback) {
       var cb = callback || angular.noop;
       return SaveRpyMessageR.save(parm, function (res) {
           return cb(res);
       }, function (err) {
           return cb(err);
       }.bind(this)).$promise;
   }
   
}
});



angular.module('app').factory('composemail', function ($resource, EMS_HOST_PORT) {
    return $resource(EMS_HOST_PORT + '/api/message/send', null, {
        'save': {
            method: 'POST'
        }
    });
});
