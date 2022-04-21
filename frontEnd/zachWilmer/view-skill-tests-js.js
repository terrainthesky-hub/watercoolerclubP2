const returnButton = document.getElementById("return-button");
const testTable = document.getElementById("view-tests-table");

async function requestInformation() {
    let requestURL = "http://localhost:8080/skilltest"
    let response = await fetch(requestURL, {method:"GET"});
    if (response.status == 200) {
        const data = await response.json();
        populatePage(data);
    }

}

function populatePage(data) {
    testTable.innerHTML = ""
    for (let key in data) {
        const row = document.createElement("tr");
        testTable.appendChild(row);

        const square1 = document.createElement("td");
        square1.textContent = data[key];
        row.appendChild(square1);

        const square2 = document.createElement("td");
        square2.innerHTML = `<button id="skillTest${key}" onclick="takeSkillTest(${key})">Take This Test</button>`
        row.appendChild(square2);
    }

}

function takeSkillTest(testID) {
    window.sessionStorage.setItem("current-test-id", testID);
    window.location.href = "take-skill-test.html";

}

function toLandingPage() {
    window.location.href = "zach-test-landing-page.html";
}