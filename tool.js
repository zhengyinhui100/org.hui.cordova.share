
var fs = require('fs'); 

function walk(path, handleFile) {  
    fs.readdir(path, function(err, files) {  
        if (err) {  
            console.log('read dir error');  
        } else {  
            files.forEach(function(item) {  
                var tmpPath = path + '/' + item;  
                fs.stat(tmpPath, function(err1, stats) {  
                    if (err1) {  
                        console.log('stat error');  
                    } else {  
                        if (stats.isDirectory()) {  
                            walk(tmpPath, handleFile);  
                        } else {  
                            handleFile(tmpPath);  
                        }  
                    }  
                })  
            });  
  
        }  
    });  
}  

var path='./res';
walk(path,function(path){
	if(path.indexOf('/values/strings.xml')<0){
		path=path.replace('./','');
		var out='<resource-file src="'+path+'" target="'+path+'"/>';
		console.log(out);
	}
})