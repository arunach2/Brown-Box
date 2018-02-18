
# Create a dictionary with 4 key-value pairs
# The keys are each strings
# The values are each ints
friends_age = {"Vikram": 24, "Varun": 24, "Vinay": 23, "Vinodh": 19}

# get method, gets the value with associated key
# This will print out the associated value, with the Key "Vikram"
# If key does not exist, will return None
print(friends_age.get("Vikram"))
print(friends_age.get("Blah"))

# get method

print(friends_age.get("Vikram", 27))

# keys methods returns a list of the keys in the dictionary (not in any particuliar order)
print(friends_age.keys())

# values methods returns a list of the values in the dictionary (not in any particuliar order)
print(friends_age.values())

# Example of how to iterate through a dictionary
for i in friends_age.keys():
	print(i + ":" + str(friends_age[i]))