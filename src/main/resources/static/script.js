document.addEventListener("DOMContentLoaded", loadIrons);
document.addEventListener("DOMContentLoaded", loadWoods);
document.addEventListener("DOMContentLoaded", loadWedges);

async function addIron() {
    let type = document.getElementById("type").value;
    let brand = document.getElementById("brand").value;
    let model = document.getElementById("model").value;
    let fullDistance = document.getElementById("fullDistance").value;
    let knockDownDistance = document.getElementById("knockDownDistance").value;
    let clubNum = document.getElementById("clubNum").value;


    let ironData = {
        type: type,
        clubNum: clubNum,
        brand: brand,
        model: model,
        fullDistance: fullDistance,
        knockDownDistance: knockDownDistance,
    };

    try {
        let response = await fetch('/irons', {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify(ironData)
        });
        loadIrons();

        if (!response.ok) {
            throw new Error('Network response was not ok ' + response.statusText);
        }

        let text = await response.text();
        document.getElementById("result").innerText = text;
    } catch (error) {
        console.error('There has been a problem with your fetch operation:', error);
        document.getElementById("result").innerText = 'Error: ' + error.message;
    }

}

async function loadIrons() {
    try {
        let response = await fetch('/irons');
        if (!response.ok) {
            throw new Error('Network response was not ok ' + response.statusText);
        }

        let irons = await response.json();
        let ironContainer = document.getElementById("ironContainer");
        ironContainer.innerHTML = '';

        irons.forEach(iron => {

            let ironDiv = document.createElement("div");
            ironDiv.className = "iron-bar";
            ironDiv.style.display = "flex";
            ironDiv.style.justifyContent = "space-between";
            ironDiv.style.border = "1px solid #ccc";
            ironDiv.style.padding = "10px";
            ironDiv.style.marginBottom = "10px";

            let ironDetails = document.createElement("span");
            ironDetails.textContent = `${iron.brand} ${iron.model} ${iron.clubNum} Iron, Distance: ${iron.fullDistance} yards`;

            let deleteButton = document.createElement("button");
            deleteButton.textContent = "Delete";
            deleteButton.style.backgroundColor = "#ff4d4d";
            deleteButton.style.color = "#fff";
            deleteButton.style.border = "none";
            deleteButton.style.padding = "5px 10px";
            deleteButton.style.cursor = "pointer";

            deleteButton.addEventListener("click", async () =>{

                try{
                let deleteResponse = await fetch(`/irons/${iron.id}`, {
                    method: "DELETE",
                    headers: {
                        'Content-Type': 'application/json'
                    }
                });

                if (!deleteResponse.ok) {
                    throw new Error('Failed to delete iron');
                }

                ironContainer.removeChild(ironDiv);
                } catch (error){
                    console.error('Error deleting iron:', error);
                }
            });

            ironDiv.appendChild(ironDetails);
            ironDiv.appendChild(deleteButton);
            ironContainer.appendChild(ironDiv);
        });
    } catch (error) {
        console.error('There has been a problem with your fetch operation:', error);
    }
}

async function addWood() {
    let type = document.getElementById("type").value;
    let brand = document.getElementById("brand").value;
    let model = document.getElementById("model").value;
    let fullDistance = document.getElementById("fullDistance").value;
    let clubNum = document.getElementById("clubNum").value;


    let woodData = {
        type: type,
        clubNum: clubNum,
        brand: brand,
        model: model,
        fullDistance: fullDistance,
    };

    try {
        let response = await fetch('/woods', {
            method: "POST",
            headers: {
                "Content-Type": "application/json"  // Set the content type to JSON
            },
            body: JSON.stringify(woodData)  // Convert the JSON object to a string
        });
        loadWoods();

        if (!response.ok) {
            throw new Error('Network response was not ok ' + response.statusText);
        }

        let text = await response.text();
        document.getElementById("result").innerText = text;
    } catch (error) {
        console.error('There has been a problem with your fetch operation:', error);
        document.getElementById("result").innerText = 'Error: ' + error.message;
    }
}

async function loadWoods() {
    try {
        let response = await fetch('/woods');
        if (!response.ok) {
            throw new Error('Network response was not ok ' + response.statusText);
        }

        let woods = await response.json();
        let woodContainer = document.getElementById("woodContainer");
        woodContainer.innerHTML = '';

        woods.forEach(wood => {
            let woodDiv = document.createElement("div");
            woodDiv.className = "wood-bar";
            woodDiv.style.display = "flex";
            woodDiv.style.justifyContent = "space-between";
            woodDiv.style.border = "1px solid #ccc";
            woodDiv.style.padding = "10px";
            woodDiv.style.marginBottom = "10px";

            let woodDetails = document.createElement("span");
            woodDetails.textContent = `${wood.brand} ${wood.model} ${wood.clubNum} Wood, Distance: ${wood.fullDistance} yards`;

            let deleteButton = document.createElement("button");
            deleteButton.textContent = "Delete";
            deleteButton.style.backgroundColor = "#ff4d4d";
            deleteButton.style.color = "#fff";
            deleteButton.style.border = "none";
            deleteButton.style.padding = "5px 10px";
            deleteButton.style.cursor = "pointer";

            deleteButton.addEventListener("click", async () =>{

                try{
                let deleteResponse = await fetch(`/woods/${wood.id}`, {
                    method: "DELETE",
                    headers: {
                        'Content-Type': 'application/json'
                    }
                });

                if (!deleteResponse.ok) {
                    throw new Error('Failed to delete wood');
                }

                woodContainer.removeChild(woodDiv);
                } catch (error){
                    console.error('Error deleting wood:', error);
                }
            });

            woodDiv.appendChild(woodDetails);
            woodDiv.appendChild(deleteButton);
            woodContainer.appendChild(woodDiv);
        });
    } catch (error) {
        console.error('There has been a problem with your fetch operation:', error);
    }
}

async function addWedge() {
    let type = document.getElementById("type").value;
    let brand = document.getElementById("brand").value;
    let model = document.getElementById("model").value;
    let fullDistance = document.getElementById("fullDistance").value;
    let knockDownDistance = document.getElementById("knockDownDistance").value;
    let loft = document.getElementById("loft").value;
    let bounce = document.getElementById("bounce").value;
    let grind = document.getElementById("grind").value;

    let wedgeData = {
        type: type,
        brand: brand,
        model: model,
        fullDistance: fullDistance,
        knockDownDistance: knockDownDistance,
        loft: loft,
        bounce: bounce,
        grind: grind
    };

    try {
        let response = await fetch('/wedges', {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify(wedgeData)
        });

        loadWedges();
        if (!response.ok) {
            throw new Error('Network response was not ok ' + response.statusText);
        }

        let text = await response.text();
        document.getElementById("result").innerText = text;
    } catch (error) {
        console.error('There has been a problem with your fetch operation:', error);
        document.getElementById("result").innerText = 'Error: ' + error.message;
    }
}

async function loadWedges() {
    try {
        let response = await fetch('/wedges');
        if (!response.ok) {
            throw new Error('Network response was not ok ' + response.statusText);
        }

        let wedges = await response.json();
        let wedgeContainer = document.getElementById("wedgeContainer");
        wedgeContainer.innerHTML = '';

        wedges.forEach(wedge => {
            let wedgeDiv = document.createElement("div");
            wedgeDiv.className = "wedge-bar";
            wedgeDiv.style.display = "flex";
            wedgeDiv.style.justifyContent = "space-between";
            wedgeDiv.style.border = "1px solid #ccc";
            wedgeDiv.style.padding = "10px";
            wedgeDiv.style.marginBottom = "10px";

            let wedgeDetails = document.createElement("span");
            wedgeDetails.textContent = `${wedge.brand} ${wedge.model} ${wedge.loft}° Wedge, Grind: ${wedge.grind}, Bounce: ${wedge.grind} Distance: ${wedge.fullDistance} yards`;

            let deleteButton = document.createElement("button");
            deleteButton.textContent = "Delete";
            deleteButton.style.backgroundColor = "#ff4d4d";
            deleteButton.style.color = "#fff";
            deleteButton.style.border = "none";
            deleteButton.style.padding = "5px 10px";
            deleteButton.style.cursor = "pointer";

            deleteButton.addEventListener("click", async () =>{

                try{
                let deleteResponse = await fetch(`/wedges/${wedge.id}`, {
                    method: "DELETE",
                    headers: {
                        'Content-Type': 'application/json'
                    }
                });

                if (!deleteResponse.ok) {
                    throw new Error('Failed to delete wedge');
                }

                wedgeContainer.removeChild(wedgeDiv);
                } catch (error){
                    console.error('Error deleting wedge:', error);
                }
            });

            wedgeDiv.appendChild(wedgeDetails);
            wedgeDiv.appendChild(deleteButton);
            wedgeContainer.appendChild(wedgeDiv);
        });
    } catch (error) {
        console.error('There has been a problem with your fetch operation:', error);
    }
}

async function calculateClub()  {
    let distance = document.getElementById("distanceInput").value;

    if (isNaN(distance) || distance <= 0) {
        document.getElementById("result").innerText = 'Please enter a valid distance.';
        return;
    }

    try {
        let response = await fetch('/clubs/closest?distance=' + encodeURIComponent(distance), {
            method: "GET",
            headers: {
                'Content-Type': 'application/json'
            }
        });

        if (!response.ok) {
            throw new Error('Network response was not ok ' + response.statusText);
        }

        let club = await response.json();

        if (club) {
            let clubDetails = '';

            if (club.type === 'Iron') {
                if (club.fullDistance > distance) {
                   clubDetails = club.clubNum? 'Soft ' + club.clubNum + ' Iron' : 'Unknown Club Number';
                } else if (club.fullDistance < distance) {
                   clubDetails = club.clubNum? 'Hard ' + club.clubNum + ' Iron' : 'Unknown Club Number';
                } else {
                   clubDetails = club.clubNum? 'Stock ' + club.clubNum + ' Iron' : 'Unknown Club Number';
                }
            } else if (club.type === 'Wood'){
                if (club.fullDistance > distance) {
                   clubDetails = club.clubNum? 'Soft ' + club.clubNum + ' Wood' : 'Unknown Club Number';
                } else if (club.fullDistance < distance) {
                   clubDetails = club.clubNum? 'Hard ' + club.clubNum + ' Wood' : 'Unknown Club Number';
                } else {
                   clubDetails = club.clubNum? 'Stock ' + club.clubNum + ' Wood' : 'Unknown Club Number';
                }
            } else if (club.type === 'Wedge') {
                if (club.fullDistance > distance) {
                   clubDetails = club.loft ? `Soft ${club.loft}° Wedge` : 'Unknown Loft';
                } else if (club.fullDistance < distance) {
                   clubDetails = club.loft ? `Hard ${club.loft}° Wedge` : 'Unknown Loft';
                } else {
                   clubDetails = club.loft ? `Stock ${club.loft}° Wedge` : 'Unknown Loft';
                }
            } else {
                clubDetails = 'Unknown club type';
            }

            document.getElementById("result").innerText = 'Recommended Club: ' + clubDetails + ' (Distance: ' + club.fullDistance + ' yards)';
        } else {
            document.getElementById("result").innerText = 'No club found for the given distance.';
        }
    } catch (error) {
        console.error('There has been a problem with your fetch operation:', error);
        document.getElementById("result").innerText = 'Error: ' + error.message;
    }
}

function getYards(lat1, lon1, lat2, lon2) {

        lon1 =  lon1 * Math.PI / 180;
        lon2 = lon2 * Math.PI / 180;
        lat1 = lat1 * Math.PI / 180;
        lat2 = lat2 * Math.PI / 180;

        // Haversine formula
        let dlon = lon2 - lon1;
        let dlat = lat2 - lat1;
        let a = Math.pow(Math.sin(dlat / 2), 2)
                 + Math.cos(lat1) * Math.cos(lat2)
                 * Math.pow(Math.sin(dlon / 2),2);

        let c = 2 * Math.asin(Math.sqrt(a));


        let r = 6975240.5949256;

        return(c * r);
}

async function getUserPosition() {


    const selectElement = document.getElementById('holeSelect');
    const holeNumber = selectElement.value;

    const response = await fetch('pinnacle.json');
    const data = await response.json();
    const holeData = data.holes[holeNumber-1];


    if (navigator.geolocation) {
       navigator.geolocation.getCurrentPosition(
         (position) => {
           const latitude = position.coords.latitude;
           const longitude = position.coords.longitude;

            if (holeData) {


                updateDistanceFromHole(latitude, longitude, holeData);

            } else {
                document.getElementById('coordinates').innerHTML = 'No data found';
            }

         },
         (error) => {
           console.error("Error getting location:", error);
         }
       );
     } else {
       console.error("Geolocation is not supported by this browser.");
     }
}

function updateDistanceFromHole(userLatitude, userLongitude, holeData) {
    const frontDistance = getYards(userLatitude, userLongitude, holeData.front.latitude, holeData.front.longitude);
    const middleDistance = getYards(userLatitude, userLongitude, holeData.middle.latitude, holeData.middle.longitude);
    const backDistance = getYards(userLatitude, userLongitude, holeData.back.latitude, holeData.back.longitude);


    const coordinatesDiv = document.getElementById('coordinates');
            coordinatesDiv.innerHTML = `
                <h3>Front: ${Math.round(frontDistance)} yards</h3>
                <h3>Middle: ${Math.round(middleDistance)} yards</h3>
                <h3>Back: ${Math.round(backDistance)} yards</h3>
    `;
}


/*
async function loadClubs() {

    try {
        let wedgeResponse = await fetch('http://localhost:8080/wedges');
        let ironResponse = await fetch('http://localhost:8080/irons');
        let woodResponse = await fetch('http://localhost:8080/woods');

        let wedges = await wedgeResponse.json();
        let irons = await ironResponse.json();
        let woods = await woodResponse.json();

        let clubContainer = document.getElementById("clubContainer");
        clubContainer.innerHTML = '';

        wedges.forEach( wedge => {
            let wedgeDiv = document.createElement("div");
            wedgeDiv.className = "wedge-bar";
            wedgeDiv.style.display = "flex";
            wedgeDiv.style.justifyContent = "space-between";
            wedgeDiv.style.border = "1px solid #ccc";
            wedgeDiv.style.padding = "10px";
            wedgeDiv.style.marginBottom = "10px";

            let wedgeDetails = document.createElement("span");
            wedgeDetails.textContent = `${wedge.brand} ${wedge.model} ${wedge.loft}° Wedge, Grind: ${wedge.grind}, Bounce: ${wedge.grind} Distance: ${wedge.fullDistance} yards`;

            wedgeDiv.appendChild(wedgeDetails);
            clubContainer.appendChild(wedgeDiv);

        })
    }
}

*/

