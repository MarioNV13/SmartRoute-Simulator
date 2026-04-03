// The function when we click on html button
async function findRoute(){
    // we take the introduced values by user using the IDs from html
    const startCity=document.getElementById('startInput').value;
    const destCity=document.getElementById('destinationInput').value;

    // we verify to not be empties
    if(!startCity || !destCity){
        alert("Please fill in both cities!");
        return;
    }

    try {
            // We send the http request to our java server (spring boot)
            // We use backticks (') to insert the variables to url
            const response = await fetch(`/api/route?start=${startCity}&dest=${destCity}`);

            // We transform the raw response in json object (like a map in java)
            const routeData = await response.json();

            // We search the display items in html
            const resultCard = document.getElementById('resultCard');
            const pathDisplay = document.getElementById('pathDisplay');
            const timeDisplay = document.getElementById('timeDisplay');

            // We put received data from java to html
            // join(" -> ") connect the cities from list with a arrow
            pathDisplay.innerText = routeData.cityList.join(" ➔ ");
            timeDisplay.innerText = routeData.formattedTime;

            // We make the card visible (we delete the class which hide it)
            resultCard.classList.remove('hidden');

        } catch (error) {
            //  If java server isn't on or the city doesn't exist
            console.error("Error fetching route:", error);
            alert("Route not found or server error!");
        }
}