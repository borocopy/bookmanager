# A simple CRUD application for managing your library

## How to run

```bash
git clone https://github.com/borocopy/bookmanager
cd bookmanager
./mvnw spring-boot:run
```

## API Routes

### Get all books
```
GET: /api/v1/book
```

### Get a book by ID
```
Get: /api/v1/book/:id
```

### Add a new book
```
POST: /api/v1/book
```

**Request body**

```json
{
  "author": "Denis Borodin",
  "title": "How to create a unicorn startup and become filthy rich!",
  "read": false
}
```

### Update a book by ID
```
POST: /api/v1/book/:id
```

**Request body**

```json
{
  "author": "Denis Borodin",
  "title": "How to create a unicorn startup and become filthy rich!",
  "read": false
}
```

*All fields are optional*
