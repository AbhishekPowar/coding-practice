package javapractice.cloning;

import java.io.Serializable;
import java.util.Objects;

public class Department implements Cloneable, Serializable {

    private static final long serialVersionUID = 1L;
    private String _id;
    private String name;
    private String code;

    public Department() {

    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public Department clone() throws CloneNotSupportedException {
        return (Department) super.clone();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Department that = (Department) o;
        return Objects.equals(_id, that._id) &&
                Objects.equals(name, that.name) &&
                Objects.equals(code, that.code);
    }

    @Override
    public int hashCode() {
        return Objects.hash(_id, name, code);
    }
}
