$("#btnGuest").click(function (){
    $("#guestUserPage").css('display','block');
    $("#landingPage").css('display','none');
});

$("#btnReturn").click(function (){
    $("#landingPage").css('display','block');
    $("#guestUserPage").css('display','none');

})