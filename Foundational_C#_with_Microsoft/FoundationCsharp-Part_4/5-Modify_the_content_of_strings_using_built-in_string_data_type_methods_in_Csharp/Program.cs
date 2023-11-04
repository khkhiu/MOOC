const string input = "<div><h2>Widgets &trade;</h2><span>5000</span></div>";

string quantity = "";
string output = "";

// Your work here

// Extract the quantity section from the input
// Find the start and end of <span> tag
int quantityStart = input.IndexOf("<span>");
int quantityEnd = input.IndexOf("</span>"); 
// Move the start index past the opening <span> tag
quantityStart = quantityStart + "<span>".Length;        
// Calculate the length of the quantity content    
int quantityLength = quantityEnd - quantityStart; 
// Extract the quantity text and format quantiy text as "Quantity: {quantity}"
quantity = input.Substring(quantityStart, quantityLength); 
quantity = $"Quantity: {quantity}"; 

// Replace the trademark symbol with the registered trademark symbol in the output
output = input.Replace("&trade;", "&reg;");

// Remove the opening <div> tag from the output
int divStart = input.IndexOf("<div>");
int divLength = "<div>".Length;
output = output.Remove(divStart, divLength);

// Remove the closing </div> tag from the output
int divCloseStart = output.IndexOf("</div>");
int divCloseLength = "</div>".Length;
output = output.Remove(divCloseStart, divCloseLength);
// Format the output text as "Output: {output}"
output = $"Output: {output}"; 

// Display the extracted quantity and modified output
Console.WriteLine(quantity);
Console.WriteLine(output);