const questionOne = document.getElementById("question-one");
const answerOne = document.getElementById("answer-one");
const questionTwo = document.getElementById("question-two");
const answerTwo = document.getElementById("answer-two");
const questionThree = document.getElementById("question-three");
const answerThree = document.getElementById("answer-three");

function findTest() {
    let requestURL = `http://localhost:8080/skilltest/${window.sessionStorage.getItem("current-test-id")}`
    let response = await fetch(requestURL, {method:"GET"});
    if (response.status == 200) {
        const data = await response.json();
        populatePage(data);
    }
}

function populatePage(data) {
    questionOne.textContent = data["questionOne"];
    questionTwo.textContent = data["questionTwo"];
    questionThree.textContent = data["questionThree"];

    window.sessionStorage.setItem("answer-one", data["answerOne"]);
    window.sessionStorage.setItem("answer-two", data["answerTwo"]);
    window.sessionStorage.setItem("answer-three", data["answerThree"]);
}

function submitTest() {
    let testPassed;

    if (answerOne.value == window.sessionStorage.getItem("answer-one") && 
    answerTwo.value == window.sessionStorage.getItem("answer-two") &&
    answerThree.value == window.sessionStory.getItem("answer-three")) {
        testPassed = true;
    } else {
        testPassed = false;
    }

}