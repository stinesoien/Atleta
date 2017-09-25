/**
 * Created by kristinweiseth on 25.09.2017.
 */
/**
 * Created by elisabethmesoy on 19.09.2017.
 */
function check(form)/*function to check userid & password*/
{
    /*the following code checkes whether the entered userid and password are matching*/
    if(form.userid.value == "myuserid" && form.pswrd.value == "mypswrd")
    {
        window.open('target.html')/*opens the target page while Id & password matches*/
    }
    else
    {
        alert("Feil passord eller brukernavn")/*displays error message*/
    }
}