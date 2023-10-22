class Solution {
public:
    Node* insert(Node* head, int insertVal) {
        Node* curr = head;
        Node* newNode = new Node(insertVal);
        while(curr!= NULL && curr -> next != head) {
            if(curr->val <= curr->next->val) {
                if(curr->val <= insertVal && curr->next->val >= insertVal)
                    break;
            } else {
                if(insertVal >= curr->val || insertVal <= curr->next->val)
                    break;
            }
            curr = curr -> next;  
        }
        if(curr) {
            newNode -> next = curr -> next;
            curr -> next = newNode;
        } else {
            head = newNode;
            newNode->next = head;
        }
        return head;
    }
};