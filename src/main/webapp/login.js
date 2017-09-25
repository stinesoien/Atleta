/**
 * Created by Stine on 25.09.2017.
 */

function check(form)/*function to check userid & password*/
{
    /*the following code checkes whether the entered userid and password are matching*/
    if(form.userid.value == "1" && form.pswrd.value == "1")
    {
        alert("Du er logget inn!")
    }
    else
    {
        alert("Feil passord eller brukernavn")/*displays error message*/
    }
}