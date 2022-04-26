const allTestsPageButton = document.getElementById("ind-view-tests");
const createTestPageButton = document.getElementById("comp-create-test");
const individualIdInput = document.getElementById("ind-id");
const companyIdInput = document.getElementById("comp-id");

function toViewAllTestsPage() {
    window.sessionStorage.setItem("individual-id", individualIdInput.value);
    window.location.href = "view-skill-tests.html"
}

function toCreateSkillTestPage() {
    window.sessionStorage.setItem("company-id", companyIdInput.value);
    window.location.href = "create-skill-test.html"
}