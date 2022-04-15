const allTestsPageButton = document.getElementById("ind-view-tests");
const createTestPageButton = document.getElementById("comp-create-test");
const individualIdInput = document.getElementById("comp-id");
const companyIdInput = document.getElementById("ind-id");

function toViewAllTestsPage() {
    window.sessionStorage.setItme("individual-id", individualIdInput.value);
    window.location.href = "view-skill-tests.html"
}

function toCreateSkillTestPage() {
    window.sessionStorage.setItem("company-id", companyIdInput.value);
    window.location.href = "create-skill-test.html"
}