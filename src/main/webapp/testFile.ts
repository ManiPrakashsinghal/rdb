/*<!DOCTYPE html>
<html>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.9/angular.min.js"></script>
<body>

<div ng-app="anApp" ng-controller="aCtrl">
    <select ng-init="setDefault()" ng-model="model" ng-options="k.value as k.key for  k in chooses">
     </select>
       
</div>


<script>
var app = angular.module('anApp', []);
app.controller('aCtrl', function($scope) {

  $scope.chooses = [{"key":"one","value":1},{"key":"Two","value":2},{"key":"Three","value":3}];
  

  $scope.setDefault = function(){
   
      $scope.model = $scope.chooses[1].value;
  }
  
   
})
</script>

<p>When you use the ng-repeat directive to create dropdown lists, the selected value must be a string.</p>
<p>In this example you will have to choose between the color or the model to be your selected value.</p>

</body>
</html>

//multiple chekcBox 
stack overflow 11945802
toString();

*/