const questionOneInput = document.getElementById("question-one");
const answerOneInput = document.getElementById("answer-one");
const questionTwoInput = document.getElementById("question-two");
const answerTwoInput = document.getElementById("answer-two");
const questionThreeInput = document.getElementById("question-three");
const answerThreeInput = document.getElementById("answer-three");

async function submitSkillTest() { 
    let skillTest = {
        "skillTestId": -1,
        "questionOne": questionOneInput.value,
        "answerOne": answerOneInput.value,
        "questionTwo": questionTwoInput.value,
        "answerTwo": answerTwoInput.value,
        "questionThree": questionThreeInput.value,
        "answerThree": answerThreeInput.value,
        "companyId": window.sessionStorage.getItem("company-id")
    };

    let config = {
        method: "POST",
        headers: {'Content-Type': "application/json"},
        body: JSON.stringify(skillTest)
    };

    const submit = await fetch("http://localhost:8080/skilltest/new", config);
    if (submit.status == 201) {
        alert("Test created successfully!");
        toLandingPage();
    } else {
        let errorMessage = await submit.json();;
        alert(errorMessage["errorMessage"]);
    }
}

function toLandingPage() {
    window.location.href = "zach-test-landing-page.html";
}