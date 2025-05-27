console.log("Welcome to the Community Portal");

window.onload = function() {
  alert("Page fully loaded!");
};
const eventName = "Community Cleanup";
const eventDate = "2025-06-01";
let availableSeats = 50;

console.log(`Event: ${eventName} on ${eventDate}. Seats left: ${availableSeats}`);

// User registers
availableSeats--;
console.log(`After registration, seats left: ${availableSeats}`);
const events = [
  { name: "Cleanup Drive", date: "2025-06-01", seats: 10 },
  { name: "Music Fest", date: "2024-05-01", seats: 0 },
  { name: "Art Show", date: "2025-07-15", seats: 5 }
];

events.forEach(event => {
  const today = new Date();
  const eventDate = new Date(event.date);

  if (eventDate > today && event.seats > 0) {
    console.log(`Upcoming: ${event.name}`);
  } else {
    console.log(`Skipping: ${event.name}`);
  }
});

function register(eventName) {
  try {
    let event = events.find(e => e.name === eventName);
    if (!event || event.seats <= 0) throw new Error("Cannot register");

    event.seats--;
    console.log(`Registered for ${eventName}`);
  } catch (error) {
    console.error(error.message);
  }
}

register("Music Fest"); // Will throw error
function addEvent(name, date, category, seats) {
  events.push({ name, date, category, seats });
}

function registerUser(eventName) {
  let event = events.find(e => e.name === eventName);
  if (event && event.seats > 0) {
    event.seats--;
    console.log(`User registered for ${eventName}`);
  }
}

function filterEventsByCategory(category) {
  return events.filter(event => event.category === category);
}

// Closure
function categoryTracker(category) {
  let count = 0;
  return function () {
    count++;
    console.log(`${category} registrations: ${count}`);
  };
}

const trackMusic = categoryTracker("Music");
trackMusic(); // 1
trackMusic(); // 2
function Event(name, date, seats) {
  this.name = name;
  this.date = date;
  this.seats = seats;
}

Event.prototype.checkAvailability = function () {
  return this.seats > 0;
};

const event1 = new Event("Food Fair", "2025-08-12", 20);

console.log(event1.checkAvailability());

console.log(Object.entries(event1));
events.push({ name: "Baking Workshop", category: "Workshop", date: "2025-09-01", seats: 30 });

const musicEvents = events.filter(e => e.category === "Music");

const formatted = events.map(e => `Event: ${e.name}`);
console.log(formatted);
const eventList = document.querySelector("#eventList");

events.forEach(event => {
  const card = document.createElement("div");
  card.textContent = `${event.name} - ${event.date}`;
  eventList.appendChild(card);
});
document.querySelector("#categoryFilter").onchange = function (e) {
  const filtered = filterEventsByCategory(e.target.value);
  console.log(filtered);
};

document.querySelector("#searchBox").addEventListener("keydown", function (e) {
  console.log(`Searching for: ${e.target.value}`);
});
fetch("mock-events.json")
  .then(res => res.json())
  .then(data => {
    console.log("Fetched events:", data);
  })
  .catch(err => console.error("Failed to fetch", err));

// Async/Await version
async function fetchEvents() {
  try {
    console.log("Loading...");
    const res = await fetch("mock-events.json");
    const data = await res.json();
    console.log(data);
  } catch (e) {
    console.error(e);
  }
}
const showEvent = ({ name, date }) => {
  console.log(`${name} on ${date}`);
};

const eventCopy = [...events];
document.querySelector("#registerForm").addEventListener("submit", function (e) {
  e.preventDefault();
  const form = e.target;
  const name = form.elements.name.value;
  const email = form.elements.email.value;

  if (!name || !email) {
    document.querySelector("#errors").textContent = "All fields required.";
    return;
  }

  console.log(`Registered ${name} for ${form.elements.event.value}`);
});
function submitRegistration(data) {
  console.log("Submitting...");

  setTimeout(() => {
    fetch("https://mockapi.io/events", {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify(data)
    })
      .then(res => res.json())
      .then(() => alert("Success!"))
      .catch(() => alert("Failed!"));
  }, 2000);
}
$('#registerBtn').click(function () {
  alert("Register clicked!");
});

$('.eventCard').fadeIn();

console.log("React or Vue helps manage complex UIs better with state and component reuse.");
