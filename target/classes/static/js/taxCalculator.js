document.addEventListener('DOMContentLoaded', () => {
    console.log("Script loaded");

    // Select required elements
    const valBox = document.getElementById("valBox");
    const taxTable = document.querySelector(".tax-table");
    const taxPerc = document.getElementById("tax-perc");
    const finalAmount = document.getElementById("final-amount");
    const calculateButton = document.querySelector(".calculate");

    // Check if all elements exist before proceeding
    if (!valBox || !calculateButton || !taxPerc || !finalAmount || !taxTable) {
        console.error("One or more elements are missing from the DOM.");
        return;
    }

    // Set initial value to 0
    valBox.value = 0;
    taxTable.style.display = "none"; // Hide tax table initially

    // Add event listener for button click
    calculateButton.addEventListener('click', () => {
        const taxableIncome = Number(valBox.value);

        if (isNaN(taxableIncome) || taxableIncome < 0) {
            alert("Please enter a valid income amount.");
            return;
        }

        // Fetch tax calculation from Spring Boot backend
        fetch(`/api/tax/calculate?income=${taxableIncome}`)
            .then(response => {
                if (!response.ok) {
                    throw new Error("Failed to fetch tax data.");
                }
                return response.json();
            })
            .then(data => {
                console.log("Tax Data:", data);

                // Update UI with API response
                taxPerc.innerText = data.taxPercentage.toFixed(2);
                finalAmount.innerText = data.tax.toLocaleString("en-US");

                // Show tax table after successful calculation
                taxTable.style.display = "block";
            })
            .catch(error => {
                console.error("Error fetching tax:", error);
                alert("Error calculating tax. Please try again.");
            });
    });
});
