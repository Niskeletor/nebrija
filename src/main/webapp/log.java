public void modificar(AdminWeb a) throws SQLException {
    String updateSql = "UPDATE useradmin SET";
    ArrayList<String> updateParts = new ArrayList<>();
    ArrayList<Object> parameters = new ArrayList<>();

    if (a.getNombre() != null) {
        updateParts.add(" name = ?");
        parameters.add(a.getNombre());
    }

    if (a.getPassw() != null) {
        updateParts.add(" contra = ?");
        parameters.add(a.getPassw());
    }

    // Aquí puede agregar las otras verificaciones para los otros campos que desee actualizar, como apellido, correo electrónico, etc.

    updateSql += String.join(",", updateParts) + " WHERE nameUsuario = ?";
    parameters.add(a.getNombreUsuario());

    PreparedStatement ps = con.prepareStatement(updateSql);
    for (int i = 0; i < parameters.size(); i++) {
        ps.setObject(i + 1, parameters.get(i));
    }

    ps.executeUpdate();
    ps.close();
}
