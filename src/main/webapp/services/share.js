app.service('share', function() {
  
	var mode = 'add';
	var detail = {};
	
  var factory = {
    setMode: setMode,
    getMode: getMode,
    setDetail:setDetail,
    getDetail:getDetail
  };
 
  function setDetail(val) {
	  detail = val;
  };

  function getDetail(){
      return detail;
  };
  
  function setMode(val) {
	  mode = val;
  };

  function getMode(){
      return mode;
  };

   return factory;

});