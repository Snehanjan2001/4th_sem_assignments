class UsernameNotUnique(Exception):
    
    def __init__(self, username):
        self.message = f"Username [`{username}`] already exists in directory"
        super().__init__(self.message)


class UserAgeException(Exception):
    
    def __init__(self, age):
        if age < 0:
            self.message = "Age cannot be negative"
        elif age < 16:
            self.message = "Age must be at least 16"
        else:
            self.message = "Unknown error"
        super().__init__(self.message)


class UserInvalidEmail(Exception):
    
    def __init__(self, email:str):
        self.message = f"{email} - email id invalid. Please enter a valid email id . e.g. tommy@example.com"
        super().__init__(self.message)

