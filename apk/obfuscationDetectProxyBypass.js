Java.perform(function(){
    var link = Java.use("android.net.LinkProperties");
    link.getHttpProxy.implementation = function(){
        console.log('getHttpProxy Hook!');
        return null;
    }
});