$("#btnGuest").click(function (){
    $("#guestUserPage").css('display','block');
     $("#carView").css('display','block')
    $("#landingPage").css('display','none');
    $("#register").css('display','none');

});

$("#btnRegister").click(function (){
    $("#guestUserPage").css('display','block');
    $("#register").css('display','block');
    $("#carView").css('display','none')
    $("#landingPage").css('display','none');

});
$("#btnViewCars").click(function (){
    $("#guestUserPage").css('display','block');
    $("#register").css('display','none');
    $("#carView").css('display','block')
    $("#landingPage").css('display','none');

});


$("#btnReturn").click(function (){
    $("#landingPage").css('display','block');
    $("#guestUserPage").css('display','none');
    $("#register").css('display','none');

});

$("#btnSubmit").click(function (){
    let UserName = $("#txtUserName").val();
    let password = $("#txtPassword").val();

    if (UserName=="dimuthu" && password=="aaa"){
       /// alert("hri");
        $("#adminPage").css('display','block');
        $("#dashBoard").css('display','block')
        $("#landingPage").css('display','none');
        $("#carManage").css('display','none');
        $("#userManage").css('display','none');
        $("#adminManage").css('display','none');
        clearTextField();

    }else if (UserName=="" && password==""){
        alert("Missing Fields")
    }else {
        alert("Please Check UserName and Password ")
        clearTextField();
    }

});

function clearTextField(){
    $("#txtUserName").val("");
    $("#txtPassword").val("");
}

$("#btnDashboard").click(function (){
    $("#dashBoard").css('display','block');
    $("#carManage").css('display','none');
    $("#userManage").css('display','none');
    $("#adminManage").css('display','none');

});
$("#btnCarManage").click(function (){
    $("#adminPage").css('display','block');
    $("#carManage").css('display','block');
    $("#dashBoard").css('display','none');
    $("#landingPage").css('display','none');
    $("#userManage").css('display','none');
    $("#adminManage").css('display','none');


});
$("#btnUserManage").click(function (){
    $("#adminPage").css('display','block');
    $("#userManage").css('display','block');
    $("#dashBoard").css('display','none');
    $("#landingPage").css('display','none');
    $("#carManage").css('display','none');
    $("#adminManage").css('display','none');
});
$("#btnAdminManage").click(function (){
    $("#adminPage").css('display','block');
    $("#adminManage").css('display','block');
    $("#userManage").css('display','none');
    $("#dashBoard").css('display','none');
    $("#landingPage").css('display','none');
    $("#carManage").css('display','none');

});

$("#btnReturnAdmin").click(function (){
    $("#landingPage").css('display','block');
    $("#adminPage").css('display','none');
   // $("#userManage").css('display','none');

});