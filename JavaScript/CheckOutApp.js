const prompt = require("prompt-sync")();

class Item {
  constructor(name, quantity, price) {
    this.name = name;
    this.quantity = quantity;
    this.price = price;
  }
  getTotalOfPurchase() {
    return this.quantity * this.price;
  }
}

function getCashierName() {
  return prompt("What is cashier's name? ");
}

function getCustomerName() {
  return prompt("What is customer's name? ");
}

function collectItems() {
  let items = [];
  while (true) {
    let name = prompt("What did our customer buy? ");
    let qty = parseInt(prompt(`How many pieces of ${name} did our customer buy? `));
    let price = parseFloat(prompt(`How much is the ${name} per unit? `));
    items.push(new Item(name, qty, price));
    let addMore = prompt("Add more items? (yes/no): ");
    if (addMore.toLowerCase() !== "yes") break;
  }
  return items;
}

function getDiscount() {
  return parseFloat(prompt("Enter discount (%): "));
}

function calculateSubTotal(items) {
  return items.reduce((sum, item) => sum + item.getTotalOfPurchase(), 0);
}

function printInvoice(items, subTotal, discount, vat, billTotal, cashierName, customerName) {
  console.log("\n================= INVOICE =================");
  printHeader(cashierName, customerName);
  printItems(items);
  console.log("-------------------------------------------");
  console.log(`Sub Total: ${subTotal.toFixed(2)}`);
  console.log(`Discount: ${discount.toFixed(2)}`);
  console.log(`VAT @ 7.50%: ${vat.toFixed(2)}`);
  console.log("-------------------------------------------");
  console.log(`Bill Total: ${billTotal.toFixed(2)}`);
  console.log("THIS IS NOT A RECEIPT. KINDLY PAY " + billTotal.toFixed(2));
  console.log("===========================================\n");
}

function getPayment() {
  return parseFloat(prompt("How much did the customer give to you? "));
}

function printReceipt(items, subTotal, discount, vat, billTotal, amountPaid, balance, cashierName, customerName) {
  console.log("\n================= RECEIPT =================");
  printHeader(cashierName, customerName);
  printItems(items);
  console.log("-------------------------------------------");
  console.log(`Sub Total: ${subTotal.toFixed(2)}`);
  console.log(`Discount: ${discount.toFixed(2)}`);
  console.log(`VAT @ 7.50%: ${vat.toFixed(2)}`);
  console.log("-------------------------------------------");
  console.log(`Bill Total: ${billTotal.toFixed(2)}`);
  console.log(`Amount Paid: ${amountPaid.toFixed(2)}`);
  console.log(`Balance: ${balance.toFixed(2)}`);
  console.log("===========================================");
  console.log("THANK YOU FOR YOUR PATRONAGE!");
}

function printHeader(cashierName, customerName) {
  const date = new Date().toLocaleString("en-GB", { hour12: true });
  console.log("SEMICOLON STORES");
  console.log("MAIN BRANCH");
  console.log("LOCATION: 312, HERBERT MACAULAY WAY, SABO YABA, LAGOS");
  console.log("TEL: 03293828343");
  console.log("Date: " + date);
  console.log("Cashier: " + cashierName);
  console.log("Customer Name: " + customerName);
  console.log("-------------------------------------------");
  console.log("ITEM       QTY   PRICE      TOTAL(NGN)");
}

function printItems(items) {
  items.forEach(item => {
    console.log(
      `${item.name.padEnd(10)} ${item.quantity
        .toString()
        .padEnd(5)} ${item.price.toFixed(2).padEnd(10)} ${item.getTotalOfPurchase().toFixed(2)}`
    );
  });
}

function main() {
  let cashierName = getCashierName();
  let customerName = getCustomerName();
  let items = collectItems();
  let discountPercent = getDiscount();
  let subTotal = calculateSubTotal(items);
  let discount = (discountPercent / 100) * subTotal;
  let vat = 0.075 * subTotal;
  let billTotal = (subTotal + vat) - discount;
  printInvoice(items, subTotal, discount, vat, billTotal, cashierName, customerName);
  let amountPaid = getPayment();
  let balance = amountPaid - billTotal;
  printReceipt(items, subTotal, discount, vat, billTotal, amountPaid, balance, cashierName, customerName);
}

main();
