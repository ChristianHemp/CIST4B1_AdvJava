# CIST4B1 Week 1 Reflection

## Time/Space Complexity Notes

Big O notation

- Focuses on the worst case scenario
- O(1) Constant TC: 
<img width="348" height="249" alt="image" src="https://github.com/user-attachments/assets/0294c865-534e-4276-8c64-f35e3e3160f5" />

Ordering Data • Sorting is fundamental to many
parts of computer science
• Previously seen importance in
binary search
• Sorting will often come up in data
structures capable of maintaining
some kind of order
• Many different algorithms, each with

Selection Sort
• Like sorting a deck of playing cards one by one
• The algorithm maintains two parts of the list: the sorted portion
and the unsorted portion
• Scan unsorted for smallest, swap into first element of sorted,
growing that part of the list

Insertion Sort
• Very closely related to Selection Sort
• Maintains unsorted and sorted parts of the list
• Rather than scanning unsorted section for the smallest and
shuffling it forward, the first unsorted element is taken and
placed in its order in the sorted array
• Unsorted array is shrunk while sorted array is grown until
complete

Coding Exercise
• Given this previous description of the pseudocode for insertion
sort, implement an insertion sort method and test it on your
IDEs.

Pop Quiz
• Given the previous pseudocode and implementation, determine
the Big O time efficiency of Selection sort and Insertion sort.
• For large datasets, is either of these sorting approaches
desirable?
Both have a time complexity of O(N2) as can be seen by the nested loops
Quadratic time complexity is not desirable for large datasets since the runtime
will grow at a rate faster than the dataset growth

What is UML
• UML stands for Unified Modeling Language.
• It’s a standardized visual language for depicting the structure
and behavior of software systems.
• UML helps in understanding, designing, and documenting
software projects.

Uses of UML
• Provides a clear and shared understanding of the system.
• Facilitates communication among stakeholders (developers,
architects, clients).
• Assists in problem-solving and decision-making.
• Serves as documentation for future reference and maintenance.

Structure Diagram
• Most common types
• Used to show how a system is structured and the relationship
between those elements
• Classes
• Objects
• Packages
• Components
• Etc

Behavioral Diagrams
• If structural diagrams focus on what a system *is* behavioral
diagrams focus on what a system *does*
• Goal is to show how the system behaves and interacts with
itself, users, other systems, and other entities more generally.

Class Diagram
• Foundational UML diagram
• Summarize neatly all the
information needed to know
about a class in a system
• Includes basic class
relationships

Class Diagram Continued
• Attributes need datatypes
• Functions need return types, parameter types
• Visibility Notation
• Based on access keywords
• + : Public
• - : Private
• # : Protected
• ~ : Package Local (Default)
• / : Derived (Inherited)

Relationship Types
• Association: Default class relationship, often used to represent “has a”
relationships.
• Simple arrow  can denote unilateral direction
• Inheritance: Represents “is a” relationships where a class inherits properties and
behavior from another
• Realization: Interface implementation relationship
• Dependency: One class relies on another for some execution (usually of function)
but is not as strong as “has a”
• Composition & Aggregation: One class contains all of another class

UML Diagram for Power Companies
• A power company operates in a region and serves various
clients.
• The company is responsible for power distribution, client
management, billing, and maintaining the power grid.
• Clients can be of different types (like residential or commercial)
and can choose from various service plans.
• Each client has a power meter and a billing account.
• The company wants to model its system to improve
management and operation efficiency.

Requirements
• Create the following classes with their respective attributes and
methods:
• PowerCompany
• Client (and its subclasses ResidentialClient and CommercialClient)
• Meter
• BillingAccount (with a composition relationship to BillingRecord)
• PowerGrid (Can exist independent of power company)
• Draw relationships between classes using logic and clues
given.
