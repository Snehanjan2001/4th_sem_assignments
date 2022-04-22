from q6_user import UsernameNotUnique, UserAgeException, UserInvalidEmail

# Dummy inputs
inputs = [
    ('snehanjan',"snehanjan@gmail.com", 32),
    ('snehanjan2',"snis@sdf.op", 45),
    ('sneha',"sbsuscu", 18)
]


directory = []

# Check and add to directory
for data in inputs:
    try:
        for user in directory:
            if user[0] == data[0]:
                raise UsernameNotUnique(data[0])
        
        if data[2] < 16:
            raise UserAgeException(data[2])
        elif "@" not in data[1] or not data[1].split("@")[1].__contains__(".") :
            raise UserInvalidEmail(data[1])
        else:
            directory.append((data[0], data[1]))
        
    except UserAgeException as e:
        print("Error =>  " + e.message)
    except UserInvalidEmail as e:
        print("Error =>  " + e.message)
    except UsernameNotUnique as e:
        print("Error =>  " + e.message)


# Verify records
for record in directory:
    print(record)