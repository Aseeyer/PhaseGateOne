function getCardType(cardNumber) {
  if (cardNumber.startsWith("4")) {
    return "Visa";
  } else if (cardNumber.startsWith("5")) {
    return "MasterCard";
  } else if (cardNumber.startsWith("37")) {
    return "American Express";
  } else if (cardNumber.startsWith("6")) {
    return "Discover";
  } else {
    return "Unknown";
  }
}

function sumOfDoubleEvenPlace(cardNumber) {
  let sum = 0;
  for (let position = cardNumber.length - 2; position >= 0; position -= 2) {
    let digit = parseInt(cardNumber.charAt(position), 10);
    let doubledValue = digit * 2;
    sum += (doubledValue > 9) ? (doubledValue - 9) : doubledValue;
  }
  return sum;
}

function sumOfOddPlace(cardNumber) {
  let sum = 0;
  for (let position = cardNumber.length - 1; position >= 0; position -= 2) {
    let digit = parseInt(cardNumber.charAt(position), 10);
    sum += digit;
  }
  return sum;
}

function isValid(cardNumber) {
  let evenSum = sumOfDoubleEvenPlace(cardNumber);
  let oddSum = sumOfOddPlace(cardNumber);
  let totalSum = evenSum + oddSum;
  return totalSum % 10 === 0;
}

const cardNumber = "4388576018402626";
console.log("Card Type:", getCardType(cardNumber));
console.log("Is Valid:", isValid(cardNumber));
