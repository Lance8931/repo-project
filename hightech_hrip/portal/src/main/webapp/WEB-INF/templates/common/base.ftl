<@css href="css/bootstrap/bootstrap.min.css" />

<script type="text/javascript">
    var rootPath = '<@url value="/"/>',staticPath = '<@static />',uploadPath = '<@fstatic />';
    function createUrl(path) {
        return encodeURI(rootPath + path);
    }
    function uploadUrl(path){
        return encodeURI(uploadPath + path);
    }
    function staticUrl(path){
    	return encodeURI(staticPath + path);
    }
</script>
<@js src="js/jquery/jquery-1.10.2.js" />
<@js src="js/bootstrap/bootstrap.min.js" />
<@js src="js/siping/common.js" />
<@js src="js/layer/layer.js" />