
public class user
{
    //Variables
    string gender;
    int age;
    double weight;
    int inches;

    //Setter Functions
    void setGender (string new_gender)
    {
        gender = new_gender;
    }
    void setAge (int new_age)
    {
        age = new_age;
    }
    void setWeight (double new_weight)
    {
        weight = new_weight;
    }
    void setInches (int new_inches)
    {
        inches = new_inches;
    }

    //Getter Functions
    string getGender ()
    {
        return gender;
    }
    int getAge ()
    {
        return age;
    }
    int getWeight ()
    {
        return weight;
    }

    //other functions
    float BMICalc(int weight, int inches)
    {
        float BMI = (703 * (weight/(inches*inches)));	//703(USA) *weight/Inches^2
        return BMI;
    }
    //constructor
    public user(string first_gender, int first_age, double first_weight, int first_inches)
    {
        gender = first_gender;
        age = first_age;
        weight = first weight;
        inches = first_inches;
    }
}
