Java.perform(function(){
    var clickListener = Java.use("com.websarva.wings.android.detectionproxyapp.ui.MainActivity$$ExternalSyntheticLambda0");
    clickListener.onClick.implementation = function(v){
        console.log('onClick() Hook!');

        // solve 1
        var mainviewmodel;
        Java.choose("com.websarva.wings.android.detectionproxyapp.viewmodel.MainViewModel", {
            onMatch: function(instance){
                mainviewmodel = instance
                console.log('mainViewModel Match()!');
            },
            onComplete: function(){}
        });

        mainviewmodel.connect();

        // solve 2
        /*
        var client = Java.use("com.websarva.wings.android.detectionproxyapp.repository.HttpConnectRepositoryClient").$new();
        var application = Java.use("android.app.Application").$new();
        var mainViewModel = Java.use("com.websarva.wings.android.detectionproxyapp.viewmodel.MainViewModel").$new(client, application);
        mainViewModel.connect();

        var main;
        Java.choose("com.websarva.wings.android.detectionproxyapp.ui.MainActivity", {
            onMatch: function(instance){
                main = instance;
                console.log('main Match()!');
            },
            onComplete: function(){}
        });
        var lamda1 = Java.use("com.websarva.wings.android.detectionproxyapp.ui.MainActivity$$ExternalSyntheticLambda1").$new(main);
        lamda1.onChanged(Java.use("java.lang.Boolean").$new(true));
        */
        
    }
});