	function previewImage(num,pic) {
		var form=$("#avatarForm" +num);
		var avatar = $("#avatarUpload"+pic);
			$.ajax({
				url: ROOT_URL + "/admin/borrow/companyUpLoad.html",
				data:new FormData(form[0]),
				type: "post",
				dataType: "json",
				cache: false,
				contentType: false,
    			processData: false,
    			success: function(path){
    				if(path.indexOf("2M!") >= 0 ){    alert(path);  return false; }  
    				var remoteFile = path.replace(/\\/g, "/");	// I Hate Windows
    				var fileName = remoteFile.substr(0, remoteFile.lastIndexOf("."));
    				fileName = ROOT_URL + fileName;
    				avatar.attr("src", fileName + ".jpg");
    				avatar.data("path", remoteFile);
    				avatar.prop("uploaded", true);
    				$("#filevalue"+num).val(remoteFile);
    			},
    			error: function(){
    				alert("上传出错，可能是网络问题！");
    			}
			});
	}
	
	function selected(){
		var selected=$("#selected").val();
		$("#filevalue").val(selected);
	}
	
	var i=1;
	function addImg1(){
		i++;
		if(i<5){
			$("#Img1").append('<form action="" id="avatarForm' +i+ '" enctype="multipart/form-data" method="post"><input type="file" name="imgFile" onchange="previewImage(' +i+ ',1)"  style="margin-bottom:10px;" style="margin-bottom:10px;"/></form>'); 
		}else{
			alert("最多添加四张图片！");
		}
	}
