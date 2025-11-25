import java.sql.*;
import java.util.ArrayList;

public class MusicaDAO {

    // CREATE
    public static void create(Musica m) {
        String sql = "INSERT INTO objetos (titulo, atributo1, atributo2, atributo3) VALUES (?, ?, ?, ?)";

        try (Connection conn = Database.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, m.getTitulo());
            stmt.setString(2, m.getAtributo1());
            stmt.setString(3, m.getAtributo2());
            stmt.setString(4, m.getAtributo3());
            stmt.executeUpdate();

            System.out.println("Registro inserido com sucesso!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // READ
    public static ArrayList<Musica> read() {

        ArrayList<Musica> lista = new ArrayList<>();

        String sql = "SELECT * FROM objetos ORDER BY id";

        try (Connection conn = Database.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {

                Musica m = new Musica(
                        rs.getInt("id"),
                        rs.getString("titulo"),
                        rs.getString("atributo1"),
                        rs.getString("atributo2"),
                        rs.getString("atributo3")
                );

                lista.add(m);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return lista;
    }

    // UPDATE
    public static void update(Musica m) {

        String sql = "UPDATE objetos SET atributo1=?, atributo2=?, atributo3=? WHERE id=?";

        try (Connection conn = Database.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, m.getAtributo1());
            stmt.setString(2, m.getAtributo2());
            stmt.setString(3, m.getAtributo3());
            stmt.setInt(4, m.getId());

            stmt.executeUpdate();
            System.out.println("Registro atualizado com sucesso!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // DELETE (corrigido)
    public static void delete(int id) {

        String sql = "DELETE FROM objetos WHERE id=?";

        try (Connection conn = Database.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("Registro deletado com sucesso!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
