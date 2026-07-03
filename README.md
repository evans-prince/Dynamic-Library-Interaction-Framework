# Dynamic Library Interaction Framework

A Java simulation of a library's book-lending backend: a request queue for borrow requests, a pending-requests list for books that are currently unavailable, and a book storage layer, all working together to process borrow requests against a fixed catalog.

A completed coursework-style exercise — the method bodies still carry their original `/* Your code here */` scaffold comments, but all of them are implemented.

## What it does

`LibraryStorage` holds a catalog of books (indexed by ISBN) and coordinates two structures:

- **`RequestQueue`** — a custom linked-list-backed FIFO queue of incoming borrow requests (ISBN + user ID)
- **`PendingRequests`** — tracks requests that couldn't be fulfilled immediately (book already borrowed)

`processQueue()` pops the front of the request queue, checks whether the requested book is available, and either marks it borrowed or moves the request to the pending list.

## Structure

```
Dynamic-Library-Interaction-Framework/
├── DriverCode.java / DriverCode2.java   # example usage / test entry points
├── LibraryStorage.java                  # top-level coordinator
├── RequestQueue.java                    # custom FIFO queue
├── PendingRequests.java                 # unresolved requests
└── Includes/
    ├── BookData.java     # per-book state (borrowed status, ISBN, dates)
    ├── UserData.java
    ├── RequestData.java
    ├── Response.java
    ├── MyDate.java
    └── Node.java         # generic linked-list node used by the custom structures
```

## Running it

```bash
javac DriverCode.java Includes/*.java *.java
java DriverCode
```

## Notes

Built to practice implementing custom data structures (linked queues, generic nodes) rather than relying on `java.util` collections for the core logic.
