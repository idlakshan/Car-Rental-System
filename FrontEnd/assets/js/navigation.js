$("#btnGuest").click(function (){
    $("#guestUserPage").css('display','block');
    $("#landingPage").css('display','none');
});

$("#btnReturn").click(function (){
    $("#landingPage").css('display','block');
    $("#guestUserPage").css('display','none');

});

$("#btnSubmit").click(function (){
    let UserName = $("#txtUserName").val();
    let password = $("#txtPassword").val();

    if (UserName=="dimuthu" && password=="aaa"){
       /// alert("hri");
        $("#adminPage").css('display','block');
        $("#dashBoard").css('display','block')
        $("#landingPage").css('display','none');
    }else if (UserName=="" && password==""){
        alert("Missing Fields")
    }

});

$("#btnDashboard").click(function (){
    $("#dashBoard").css('display','block');
    $("#landingPage").css('display','none');

});