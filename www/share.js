

var exec = require('cordova/exec');

module.exports = {

    share: function(oParams) {
    	exec(oParams.success, oParams.error, "Share", "show", 
    	[oParams.title,oParams.content,oParams.url,oParams.imgUrl,oParams.comment,oParams.site]);
    }
};
