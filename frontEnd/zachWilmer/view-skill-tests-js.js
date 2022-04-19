const returnButton = document.getElementById("return-button");
const testTable = document.getElementById("view-tests-table");

async function requestInformation() {
    let requestURL = "http://localhost:8080//skilltest"
    let response = await fetch(requestURL, {method:"GET"});
    if (response.status == 200) {
        const data = await response.json();
        populatePage(data);
    }

}

function populatePage(data) {
    

}

function takeSkillTest(testID) {

}

function toLandingPage() {
    window.location.href = "zach-test-landing-page.html";
}